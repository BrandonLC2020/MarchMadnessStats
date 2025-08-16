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
                <div style={{ height: 400, width: '100%' }}>
                    <DataGrid
                        rows={rows}
                        columns={columns}
                        filterModel={filterModel}
                        onFilterModelChange={(model) => setFilterModel(model)}
                    />
                </div>
            </Paper>
        </Box>
    );
};

export default RankingsView;