# March Madness Stats 🏀

Welcome to March Madness Stats, a full-stack web application designed to provide detailed statistics and information for NCAA Men's College Basketball. This application features a React frontend and a Spring Boot backend, allowing users to browse through data on games, teams, players, conferences, and historical rankings.

## Features ✨

  * **Games View**: Search for games by a single date or a date range and view game-by-game results.
  * **Rankings Explorer**: View historical AP poll rankings by season and week.
  * **Conference Data**: Browse a list of all NCAA conferences and view the teams associated with each one.
  * **Team Details**: Get a detailed view of each team, including their current season stats, shooting statistics, and complete roster.
  * **Player Profiles**: View individual player information and their season-by-season statistics.
  * **Detailed Game Breakdowns**: Click on any game to see a full box score for both teams and individual players.

## Tech Stack 🛠️

This project is a full-stack application with the following technologies:

### Frontend

  * **React**
  * **TypeScript**
  * **Material-UI (MUI)** for components and styling
  * **React Router** for navigation

### Backend

  * **Java 21**
  * **Spring Boot 3**
  * **Maven** for dependency management
  * **JPA (Hibernate)** for data persistence
  * **OpenAPI Generator** to create REST API definitions from a Swagger/OpenAPI specification.

-----

## Project Structure

The project is organized into two main directories:

  - `march-madness-stats/backend/`: Contains the Spring Boot application that serves the REST API.
  - `march-madness-stats/frontend/`: Contains the React single-page application.

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

2.  **Create a `.env` file**: In the `march-madness-stats/frontend/` directory, create a `.env` file to specify the backend API URL.

    ```env
    REACT_APP_API_URL=http://localhost:8080
    API_KEY=your_api_key_if_needed 
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

This project is licensed under the MIT License. See the [LICENSE](https://www.google.com/search?q=brandonlc2020/marchmadnessstats/MarchMadnessStats-fb34e69e87b40839ccd4b6b175d09c6086a058b1/LICENSE) file for details.
