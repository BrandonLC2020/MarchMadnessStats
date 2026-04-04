const fs = require('fs');
const path = require('path');

const LOG_PATH = process.argv[2] || path.resolve(__dirname, '../../../march-madness-stats/backend/app.log');

if (!fs.existsSync(LOG_PATH)) {
    console.log(`Log file not found at ${LOG_PATH}. Waiting for log file to be created...`);
}

function parseLogs() {
    if (!fs.existsSync(LOG_PATH)) return;
    const content = fs.readFileSync(LOG_PATH, 'utf8');
    const lines = content.split('
');
    
    // Look for x-ratelimit-remaining headers in logs (assuming backend logs them)
    const rateLimitMatches = lines.filter(l => l.includes('x-ratelimit-remaining')).reverse();
    
    if (rateLimitMatches.length > 0) {
        console.log('--- CBB API Rate Limit Status ---');
        console.log(`Latest entry: ${rateLimitMatches[0]}`);
    } else {
        console.log('No rate limit headers found in logs. (Ensure backend logging is set to DEBUG for CbbApiService)');
    }
}

parseLogs();
