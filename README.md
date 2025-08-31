# March Madness Stats 🏀

Welcome to **March Madness Stats**, a full-stack web application designed to provide detailed statistics and information for NCAA Men's College Basketball. This application features a React frontend that communicates with a Spring Boot backend, which in turn retrieves data from the College Basketball Data API. This architecture allows for a robust and scalable application where users can browse through data on games, teams, players, conferences, and historical rankings.

## Features ✨

  * **Games View**: Search for games by a single date or a date range and view game-by-game results.
  * **Rankings Explorer**: View historical AP poll rankings by season and week.
  * **Conference Data**: Browse a list of all NCAA conferences and view the teams associated with each one.
  * **Team Details**: Get a detailed view of each team, including their current season stats, shooting statistics, and complete roster.
  * **Player Profiles**: View individual player information and their season-by-season statistics.
  * **Detailed Game Breakdowns**: Click on any game to see a full box score for both teams and individual players.
  * **Gemini Stat Analysis**: Leverage Google Gemini to get AI-powered analysis of team and player statistics.
  * **Firebase Integration**: Save your favorite teams and players for easy access.

-----

## Tech Stack 🛠️

This project is a full-stack application with the following technologies:

### Frontend

  * **React**
  * **TypeScript**
  * **Material-UI (MUI)** for components and styling
  * **React Router** for navigation
  * **Firebase** for user authentication and data persistence (favorites)
  * **Google Gemini** for AI-powered data analysis

### Backend

  * **Java 21**
  * **Spring Boot 3**: Acts as a middleware, fetching data from the CBB API and serving it to the React frontend.
  * **Maven** for dependency management
  * **JPA (Hibernate)** for data persistence
  * **OpenAPI Generator** to create REST API definitions from a Swagger/OpenAPI specification.

-----

## Project Structure

The project is organized into two main directories:

  * `march-madness-stats/backend/`: Contains the Spring Boot application that serves as the middleman between the frontend and the CBB API.
  * `march-madness-stats/frontend/`: Contains the React single-page application that consumes data from the Spring Boot backend.

-----

## Setup and Installation 🚀

To get this project up and running on your local machine, follow these steps.

### Prerequisites

  * **Java JDK 21** or later
  * **Apache Maven**
  * **Node.js and npm**

### Backend Setup

1.  **Navigate to the backend directory**:
    ```bash
    cd march-madness-stats/backend
    ```
2.  **Install dependencies and build the project**: Maven will handle this process. The `openapi-generator-maven-plugin` will also generate the API controllers and models from the `swagger.json` file.
    ```bash
    mvn clean install
    ```
3.  **Run the application**:
    ```bash
    mvn spring-boot:run
    ```
    The backend server should now be running, typically on `http://localhost:8080`.

### Frontend Setup

1.  **Navigate to the frontend directory**:
    ```bash
    cd march-madness-stats/frontend
    ```
2.  **Create a `.env` file**: In the `march-madness-stats/frontend/` directory, create a `.env` file to specify the backend API URL and your Firebase/Gemini API keys.
    ```env
    LOCAL_BASE_URL=http://localhost:8080
    CBB_API_KEY=your_api_key_if_needed 
    FIREBASE_API_KEY=your_firebase_api_key
    FIREBASE_AUTH_DOMAIN=your_firebase_auth_domain
    FIREBASE_PROJECT_ID=your_firebase_project_id
    FIREBASE_STORAGE_BUCKET=your_firebase_storage_bucket
    FIREBASE_MESSAGING_SENDER_ID=your_firebase_messaging_sender_id
    FIREBASE_APP_ID=your_firebase_app_id
    GEMINI_API_KEY=your_gemini_api_key
    ```
3.  **Install dependencies**:
    ```bash
    npm install
    ```
4.  **Start the development server**:
    ```bash
    npm start
    ```
    The React application will open in your browser at `http://localhost:3000`.

-----

## Usage 🧑‍💻

Once both the backend and frontend are running, you can start exploring the application:

  * The **Homepage** provides navigation to the main sections: Games, Conferences, and Rankings.
  * From the **Conferences** page, you can click on a conference to see its member teams.
  * From the **Team** page, you can view detailed stats and click on a player's name in the roster to navigate to their individual page.

-----

## License 📄

This project is licensed under the MIT License. See the [LICENSE](https://www.google.com/search?q=LICENSE) file for details.
