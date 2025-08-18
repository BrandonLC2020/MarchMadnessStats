import React, { useState, useMemo, useEffect } from 'react';
import { Typography, Box, Paper, Button, Popover, TextField, MenuItem, Chip, TableContainer, TableBody, Table, TableCell, TableRow, TableHead, CircularProgress } from '@mui/material';
import { GridColDef, GridFilterModel } from '@mui/x-data-grid';
import { useRankings } from '../hooks/useRankings';
import { PollTeamInfo, SeasonType } from '../types/api';
import { SEASON_MAX_WEEKS, SEASON_MIN_WEEKS, SEASON_SEARCH_OPTIONS, SEASON_WITH_PRESEASONS, SEASON_WITH_POSTSEASONS } from '../types/currentData';

const columns: GridColDef[] = [
    { field: 'ranking', headerName: 'Rank', type: 'number', width: 150 },
    { field: 'team', headerName: 'Team', width: 110 },
    { field: 'conference', headerName: 'Conference', width: 160 },
    { field: 'points', headerName: 'Points', width: 160 },
    { field: 'firstPlaceVotes', headerName: 'First Place Votes', width: 160 }
];

const conferenceFilterOptions: { value: string; label: string }[] = [
    { value: 'ACC', label: 'ACC' },
    { value: 'Big 12', label: 'Big 12' },
    { value: 'Big Ten', label: 'Big Ten' },
    { value: 'Pac-12', label: 'Pac-12' },
    { value: 'SEC', label: 'SEC' },
    //TODO: add the remaining conferences
];

const RankingsView: React.FC = () => {
    const [anchorEl, setAnchorEl] = useState<HTMLButtonElement | null>(null);
    const [filterModel, setFilterModel] = useState<GridFilterModel>({ items: [] });
    const [filterConference, setFilterConference] = useState('');
    const [data, setData] = useState<PollTeamInfo[]>([]); // Replace 'any' with your actual data type
    const [searchWeek, setSearchWeek] = useState<number | string | undefined>();
    const [searchSeason, setSearchSeason] = useState<number | string | undefined>();
    const [loading, setLoading] = useState(false); // State to track loading
    const { getRankings } = useRankings();

    // Reset week when season changes
    useEffect(() => {
        setSearchWeek(undefined);
    }, [searchSeason]);
    
    // Filter the week options based on the selected season
    const filteredWeekOptions = useMemo(() => {
        if (!searchSeason) {
            return []; // No season selected, so no weeks to show
        }
        const maxWeek = SEASON_MAX_WEEKS[searchSeason as number] || 20; // Default to 20 if season not in our map
        const minWeek = SEASON_MIN_WEEKS[searchSeason as number] || 2; // Default to 2 if season not in our map
        return SEASON_SEARCH_OPTIONS.filter(option => {
            if (typeof option.value === 'string') {
                if (option.value === 'preseason' && SEASON_WITH_PRESEASONS[searchSeason as number]) {
                    return true;
                } else if (option.value === 'postseason' && SEASON_WITH_POSTSEASONS[searchSeason as number]) {
                    return true;
                }
            }
            return typeof option.value === 'number' && option.value <= maxWeek && option.value >= minWeek;
        });
    }, [searchSeason]);

    const handleClick = (event: React.MouseEvent<HTMLButtonElement>) => {
        setAnchorEl(event.currentTarget);
    };

    const handleClose = () => {
        setAnchorEl(null);
    };

    const handleApplyFilter = () => {
        if (filterConference) {
            setFilterModel({
                items: [{ field: 'conference', operator: 'equals', value: filterConference }],
            });
        } else {
            setFilterModel({ items: [] });
        }
        handleClose();
    };

    const handleSearchRankings = async () => {
        setLoading(true);
        try {
            const params = {
                season: searchSeason as number,
                pollType: 'AP',
                ...(typeof searchWeek === 'string' && (searchWeek === 'preseason' || searchWeek === 'postseason')
                    ? { seasonType: searchWeek as SeasonType }
                    : { seasonType: 'regular' as SeasonType, week: searchWeek as number })
            };
            const rankingsData = await getRankings(params);
            setData(rankingsData);
        } catch (error) {
            console.error("Error fetching rankings:", error);
            setData([]); // Clear data on error
        } finally {
            setLoading(false);
        }
    }

    const open = Boolean(anchorEl);
    const id = open ? 'filter-popover' : undefined;

    return (
        <Box sx={{ p: 3 }}>
            <Typography variant="h4" component="h1" gutterBottom>
                Rankings
            </Typography>
            <Box sx={{ direction: 'row', display: 'flex', justifyContent: 'space-between', mb: 2 }}>
                <TextField
                    select
                    label="Season"
                    value={searchSeason}
                    onChange={(e) => setSearchSeason(e.target.value)}
                >
                    {SEASON_SEARCH_OPTIONS.map((option) => (
                        <MenuItem key={option.value} value={option.value}>
                            {option.label}
                        </MenuItem>
                    ))}
                </TextField>
                <TextField
                    select
                    label="Week"
                    value={searchWeek}
                    onChange={(e) => setSearchWeek(e.target.value)}
                    disabled={!searchSeason}
                >
                    {/* Use the new filtered list of options */}
                    {filteredWeekOptions.map((option) => (
                        <MenuItem key={option.value} value={option.value}>
                            {option.label}
                        </MenuItem>
                    ))}
                </TextField>
                <Button variant="contained" color="primary" onClick={handleSearchRankings} disabled={!searchWeek || !searchSeason}>
                    Get Rankings
                </Button>
                <Button aria-describedby={id} variant="contained" onClick={handleClick} disabled={!searchWeek || !searchSeason}>
                    Filter By Conference
                </Button>
                <Popover
                    id={id}
                    open={open}
                    anchorEl={anchorEl}
                    onClose={handleClose}
                    anchorOrigin={{
                        vertical: 'bottom',
                        horizontal: 'left',
                    }}
                >
                    <Box sx={{ p: 2, display: 'flex', flexDirection: 'column', gap: 2 }}>
                        {conferenceFilterOptions.map((option) => (
                            <Chip
                                key={option.value}
                                label={option.label}
                                onClick={() => setFilterConference(option.value)}
                                color={filterConference === option.value ? 'primary' : 'default'}
                            />
                        ))}
                        <Button onClick={handleApplyFilter} variant="contained">
                            Apply
                        </Button>
                    </Box>
                </Popover>
            </Box>
            <TableContainer component={Paper}>
                <Table>
                    <TableHead>
                        <TableRow>
                            {columns.map((column) => (
                                <TableCell key={column.field} align={column.align}>
                                    {column.headerName}
                                </TableCell>
                            ))}
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {loading ? (
                            <TableRow>
                                <TableCell colSpan={columns.length} align="center" sx={{ py: 5 }}>
                                    <CircularProgress />
                                </TableCell>
                            </TableRow>
                        ) : data.length > 0 ? (
                            data.map((row) => (
                                <TableRow key={row.teamId}>
                                    {columns.map((column) => (
                                        <TableCell key={column.field} align={column.align}>
                                            {row[column.field as keyof PollTeamInfo]}
                                        </TableCell>
                                    ))}
                                </TableRow>
                            ))
                        ) : (
                            <TableRow>
                                <TableCell colSpan={columns.length} align="center">
                                    No rankings found. Please select a season and week.
                                </TableCell>
                            </TableRow>
                        )}
                    </TableBody>
                </Table>
            </TableContainer>
        </Box>
    );
};

export default RankingsView;