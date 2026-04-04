const fs = require('fs');
const path = require('path');

const ENV_PATH = path.resolve(__dirname, '../../../march-madness-stats/frontend/.env');
const REQUIRED_VARS = [
  'REACT_APP_FIREBASE_API_KEY',
  'REACT_APP_FIREBASE_AUTH_DOMAIN',
  'REACT_APP_FIREBASE_PROJECT_ID',
  'REACT_APP_FIREBASE_STORAGE_BUCKET',
  'REACT_APP_FIREBASE_MESSAGING_SENDER_ID',
  'REACT_APP_FIREBASE_APP_ID',
  'REACT_APP_GEMINI_API_KEY',
  'REACT_APP_LOCAL_BASE_URL'
];

if (!fs.existsSync(ENV_PATH)) {
  console.error(`❌ Error: .env file not found in frontend/.env`);
  process.exit(1);
}

const envContent = fs.readFileSync(ENV_PATH, 'utf8');
const missing = [];

REQUIRED_VARS.forEach(v => {
  if (!envContent.includes(`${v}=`) || envContent.match(new RegExp(`${v}=[\s]*$`))) {
    missing.push(v);
  }
});

if (missing.length > 0) {
  console.error(`❌ Missing or empty environment variables in frontend/.env:`);
  missing.forEach(m => console.error(`   - ${m}`));
  process.exit(1);
} else {
  console.log(`✅ All required frontend environment variables are set.`);
}
