import React, { useState } from 'react';
import { Typography, Box, Paper, Button, Popover, TextField, MenuItem } from '@mui/material';
import { DataGrid, GridColDef, GridFilterModel } from '@mui/x-data-grid';

const columns: GridColDef[] = [
    { field: 'id', headerName: 'ID', width: 90 },
    { field: 'name', headerName: 'Name', width: 150 },
    { field: 'rank', headerName: 'Rank', type: 'number', width: 110 },
    { field: 'category', headerName: 'Category', width: 160 },
];

const rows = [
    { id: 1, name: 'Alpha', rank: 1, category: 'A' },
    { id: 2, name: 'Bravo', rank: 2, category: 'B' },
    { id: 3, name: 'Charlie', rank: 3, category: 'A' },
    { id: 4, name: 'Delta', rank: 4, category: 'C' },
    { id: 5, name: 'Echo', rank: 5, category: 'B' },
];

const seasonFilterOptions = [
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

const weekFilterOptions: { value: number | string; label: string }[] = [
    { value: 'preseason', label: 'Preseason' },
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
    const [filterColumn, setFilterColumn] = useState('');
    const [filterOperator, setFilterOperator] = useState('contains');
    const [filterValue, setFilterValue] = useState('');

    const handleClick = (event: React.MouseEvent<HTMLButtonElement>) => {
        setAnchorEl(event.currentTarget);
    };

    const handleClose = () => {
        setAnchorEl(null);
    };

    const handleApplyFilter = () => {
        if (filterColumn && filterValue) {
            setFilterModel({
                items: [{ field: filterColumn, operator: filterOperator, value: filterValue }],
            });
        } else {
            setFilterModel({ items: [] });
        }
        handleClose();
    };

    const open = Boolean(anchorEl);
    const id = open ? 'filter-popover' : undefined;

    return (
        <Box sx={{ p: 3 }}>
            <Typography variant="h4" component="h1" gutterBottom>
                Rankings
            </Typography>
            <Button aria-describedby={id} variant="contained" onClick={handleClick}>
                Open Filters
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
                    <TextField
                        select
                        label="Column"
                        value={filterColumn}
                        onChange={(e) => setFilterColumn(e.target.value)}
                        variant="standard"
                    >
                        {columns.map((col) => (
                            <MenuItem key={col.field} value={col.field}>
                                {col.headerName}
                            </MenuItem>
                        ))}
                    </TextField>
                    <TextField
                        select
                        label="Operator"
                        value={filterOperator}
                        onChange={(e) => setFilterOperator(e.target.value)}
                        variant="standard"
                    >
                        <MenuItem value="contains">Contains</MenuItem>
                        <MenuItem value="equals">Equals</MenuItem>
                        <MenuItem value="startsWith">Starts With</MenuItem>
                        <MenuItem value="endsWith">Ends With</MenuItem>
                        <MenuItem value="isAnyOf">Is Any Of</MenuItem>
                    </TextField>
                    <TextField
                        label="Value"
                        value={filterValue}
                        onChange={(e) => setFilterValue(e.target.value)}
                        variant="standard"
                    />
                    <Button onClick={handleApplyFilter} variant="contained">
                        Apply
                    </Button>
                </Box>
            </Popover>
            <Paper sx={{ p: 2, textAlign: 'center', mt: 2 }}>
                <DataGrid
                    rows={rows}
                    columns={columns}
                    filterModel={filterModel}
                    onFilterModelChange={(model) => setFilterModel(model)}
                />
            </Paper>
        </Box>
    );
};

export default RankingsView;