# News Fetcher

A lightweight Java application that retrieves and displays the latest news from an online source.

## Overview

This project fetches live news articles from an external API and presents them in a user-friendly format. Users can browse headlines and select specific articles for more details.

## Features

- Fetches and lists the most recent news articles.
- Displays detailed information about each article.
- Handles incorrect user inputs gracefully.
- Demonstrates HTTP requests, JSON parsing, and command-line interaction.

## Requirements

Ensure the following are installed before running the application:

- **Java 23** (Required for compilation and execution)
- **Gradle** (For dependency management)
- **Git** (For version control)
- **News API Key** (Needed to retrieve news articles)

## Installation

1. Clone this repository to your local machine.
2. Obtain an API key from News API.
3. Install required dependencies using Gradle.

## How to Use

1. Compile the project using Gradle.
2. Run the application from the terminal.
3. Browse through the list of news articles.
4. Select an article to view more details.
5. If an invalid input is provided, the system will prompt again.

## Troubleshooting

### Handling Invalid Inputs
- **Issue:** Users may enter incorrect values.
- **Solution:** Implemented input validation to ensure correct selections.

## Author

- Mahdi Hoseinpoor

## Version History

- **v1.0** - Initial release with core functionality.

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).

## Credits

This project uses:

- **News API** – For real-time news data.
- **Gson Library** – For parsing JSON efficiently.