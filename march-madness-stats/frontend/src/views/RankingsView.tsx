import React, { useState, useMemo, useEffect } from 'react';
import { Typography, Box, Paper, Button, Popover, TextField, MenuItem, Chip, TableContainer, TableBody, Table, TableCell, TableRow, TableHead } from '@mui/material';
import { DataGrid, GridColDef, GridFilterModel } from '@mui/x-data-grid';
import { useRankings } from '../hooks/useRankings';
import { PollTeamInfo } from '../types/api';

const columns: GridColDef[] = [
    { field: 'ranking', headerName: 'Rank', type: 'number', width: 150 },
    { field: 'team', headerName: 'Team', width: 110 },
    { field: 'conference', headerName: 'Conference', width: 160 },
    { field: 'points', headerName: 'Points', width: 160 },
    { field: 'firstPlaceVotes', headerName: 'First Place Votes', width: 160 }
];

const rows = [
    { id: 1, name: 'Alpha', rank: 1, conference: 'A' },
    { id: 2, name: 'Bravo', rank: 2, conference: 'B' },
    { id: 3, name: 'Charlie', rank: 3, conference: 'A' },
    { id: 4, name: 'Delta', rank: 4, conference: 'C' },
    { id: 5, name: 'Echo', rank: 5, conference: 'B' },
];

const seasonSearchOptions = [
    { value: 2025, label: '2024-25' },
    { value: 2024, label: '2023-24' },
    { value: 2023, label: '2022-23' },
    { value: 2022, label: '2021-22' },
    { value: 2021, label: '2020-21' },
    { value: 2020, label: '2019-20' },
    { value: 2019, label: '2018-19' },
    { value: 2018, label: '2017-18' },
    { value: 2017, label: '2016-17' },
    { value: 2016, label: '2015-16' },
    { value: 2015, label: '2014-15' },
    { value: 2014, label: '2013-14' },
    { value: 2013, label: '2012-13' },
    { value: 2012, label: '2011-12' },
    { value: 2011, label: '2010-11' },
    { value: 2010, label: '2009-10' },
    { value: 2009, label: '2008-09' },
    { value: 2008, label: '2007-08' },
    { value: 2007, label: '2006-07' },
    { value: 2006, label: '2005-06' },
    { value: 2005, label: '2004-05' },
    { value: 2004, label: '2003-04' },
    { value: 2003, label: '2002-03' }
];

const weekSearchOptions: { value: number | string; label: string }[] = [
    { value: 'preseason', label: 'Preseason' },
    { value: 1, label: 'Week 1' },
    { value: 2, label: 'Week 2' },
    { value: 3, label: 'Week 3' },
    { value: 4, label: 'Week 4' },
    { value: 5, label: 'Week 5' },
    { value: 6, label: 'Week 6' },
    { value: 7, label: 'Week 7' },
    { value: 8, label: 'Week 8' },
    { value: 9, label: 'Week 9' },
    { value: 10, label: 'Week 10' },
    { value: 11, label: 'Week 11' },
    { value: 12, label: 'Week 12' },
    { value: 13, label: 'Week 13' },
    { value: 14, label: 'Week 14' },
    { value: 15, label: 'Week 15' },
    { value: 16, label: 'Week 16' },
    { value: 17, label: 'Week 17' },
    { value: 18, label: 'Week 18' },
    { value: 19, label: 'Week 19' },
    { value: 20, label: 'Week 20' },
    { value: 'postseason', label: 'Postseason' }
];

const seasonMaxWeeks: { [key: number]: number } = {
    2025: 20,
    2024: 20,
    2023: 19, 
    2022: 19,
    2021: 17,
    2020: 19,
    2019: 20,
    2018: 18,
    2017: 18,
    2016: 18,
    2015: 18,
    2014: 19,
    2013: 19,
    2012: 18,
    2011: 18,
    2010: 18,
    2009: 18,
    2008: 19,
    2007: 18,
    2006: 18,
    2005: 17,
    2004: 17,
    2003: 18
};

const seasonMinWeeks: { [key: number]: number } = {
    2025: 2,
    2024: 2,
    2023: 2, 
    2022: 2,
    2021: 2,
    2020: 2,
    2019: 2,
    2018: 2,
    2017: 2,
    2016: 2,
    2015: 2,
    2014: 2,
    2013: 2,
    2012: 2,
    2011: 2,
    2010: 2,
    2009: 2,
    2008: 2,
    2007: 2,
    2006: 2,
    2005: 2,
    2004: 1,
    2003: 1
};

const seasonWithPreseasons: { [key: number]: boolean } = {
    2025: true,
    2024: true,
    2023: true,
    2022: true,
    2021: true,
    2020: true,
    2019: true,
    2018: true,
    2017: true,
    2016: true,
    2015: true,
    2014: true,
    2013: true,
    2012: true,
    2011: true,
    2010: true,
    2009: true,
    2008: true,
    2007: true,
    2006: true,
    2005: true,
    2004: false,
    2003: false
};

const seasonWithPostseasons: { [key: number]: boolean } = {
    2025: true,
    2024: true,
    2023: false,
    2022: false,
    2021: false,
    2020: true,
    2019: false,
    2018: false,
    2017: true,
    2016: false,
    2015: false,
    2014: false,
    2013: false,
    2012: false,
    2011: false,
    2010: false,
    2009: false,
    2008: false,
    2007: true,
    2006: false,
    2005: false,
    2004: false,
    2003: false
};

const conferenceFilterOptions: { value: string; label: string }[] = [
    { value: 'ACC', label: 'ACC' },
    { value: 'Big 12', label: 'Big 12' },
    { value: 'Big Ten', label: 'Big Ten' },
    { value: 'Pac-12', label: 'Pac-12' },
    { value: 'SEC', label: 'SEC' },
];

const RankingsView: React.FC = () => {
    const [anchorEl, setAnchorEl] = useState<HTMLButtonElement | null>(null);
    const [filterModel, setFilterModel] = useState<GridFilterModel>({ items: [] });
    const [filterConference, setFilterConference] = useState('');
    const [data, setData] = useState<PollTeamInfo[]>([]); // Replace 'any' with your actual data type
    const [searchWeek, setSearchWeek] = useState<number | string | undefined>();
    const [searchSeason, setSearchSeason] = useState<number | string | undefined>();
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
        const maxWeek = seasonMaxWeeks[searchSeason as number] || 20; // Default to 20 if season not in our map
        const minWeek = seasonMinWeeks[searchSeason as number] || 2; // Default to 2 if season not in our map
        return weekSearchOptions.filter(option => {
            if (typeof option.value === 'string') {
                if (option.value === 'preseason' && seasonWithPreseasons[searchSeason as number]) {
                    return true;
                } else if (option.value === 'postseason' && seasonWithPostseasons[searchSeason as number]) {
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
        if (typeof searchWeek === 'string') {
            try {
                const data = await getRankings({season: searchSeason as number, seasonType: searchWeek as 'preseason' | 'postseason', pollType: 'AP'});
                setData(data);
            } catch (error) {
                console.error("Error fetching rankings:", error);
            }
        } else {
            try {
                const data = await getRankings({season: searchSeason as number, seasonType: 'regular', week: searchWeek as number, pollType: 'AP'});
                setData(data);
            } catch (error) {
                console.error("Error fetching rankings:", error);
            }
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
                    {seasonSearchOptions.map((option) => (
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
                        {data.map((row) => (
                            <TableRow key={row.teamId}>
                                {columns.map((column) => (
                                    <TableCell key={column.field} align={column.align}>
                                        {row[column.field as keyof PollTeamInfo]}
                                    </TableCell>
                                ))}
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </Box>
    );
};

export default RankingsView;