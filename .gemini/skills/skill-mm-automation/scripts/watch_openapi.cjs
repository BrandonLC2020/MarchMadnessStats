const fs = require('fs');
const { execSync } = require('child_process');
const path = require('path');

const SCHEMA_PATH = path.resolve(__dirname, '../../../march-madness-stats/backend/src/main/resources/schemas/swagger.json');
const BACKEND_ROOT = path.resolve(__dirname, '../../../march-madness-stats/backend');

if (!fs.existsSync(SCHEMA_PATH)) {
    console.error(`Error: Schema file not found at ${SCHEMA_PATH}`);
    process.exit(1);
}

console.log(`Watching for changes in: ${SCHEMA_PATH}...`);

fs.watchFile(SCHEMA_PATH, { interval: 1000 }, (curr, prev) => {
    if (curr.mtime > prev.mtime) {
        console.log('Schema changed. Running mvn clean install in backend...');
        try {
            execSync('mvn clean install', { cwd: BACKEND_ROOT, stdio: 'inherit' });
            console.log('✅ Backend regenerated successfully.');
        } catch (error) {
            console.error('❌ Maven build failed. Check swagger.json for errors.');
        }
    }
});
