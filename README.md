# Stock Data Fetching Website

## Overview
This project is a web application that fetches real-time stock data using the Alpha Vantage API. Users can enter the name of any stock, and the application retrieves and displays the latest updated price available from the API call.

## Features
- Fetches real-time stock prices using the Alpha Vantage API.
- User-friendly interface with a simple HTML & CSS frontend.
- Backend built with Spring Boot to handle API calls and process responses.

## Technologies Used
### Backend:
- **Spring Boot**: Framework used for developing the backend.
- **Maven**: Build automation tool for managing dependencies.
- **REST API**: Consumes Alpha Vantage API to fetch stock data.
- **Java**: Core programming language for backend development.

### Frontend:
- **HTML**: Markup language for structuring web pages.
- **CSS**: Styling for a responsive and visually appealing user interface.

## Installation & Setup
### Prerequisites:
- Java (JDK 8 or later)
- Maven
- An Alpha Vantage API Key (Sign up at [Alpha Vantage](https://www.alphavantage.co/))

### Steps to Run the Project:
1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/stock-data-fetcher.git
   cd stock-data-fetcher
   ```
2. Configure API Key:
   - Open `application.properties` (in `src/main/resources`)
   - Add your Alpha Vantage API key:
     ```properties
     alphavantage.api.key=YOUR_API_KEY_HERE
     ```
3. Build and run the application using Maven:
   ```sh
   mvn spring-boot:run
   ```
4. Open the frontend:
   - Navigate to `src/main/resources/static/index.html` and open it in a browser.

## API Usage
The backend makes a GET request to Alpha Vantage's API endpoint to fetch stock data:
```
https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=SYMBOL&interval=5min&apikey=YOUR_API_KEY
```

## Future Enhancements
- Improve UI with JavaScript for dynamic content updates.
- Add historical stock data visualization.
- Deploy the project to a cloud platform.

## License
This project is open-source and available under the MIT License.

