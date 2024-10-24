
# Java WEKA Iris Prediction App

This project is a Spring Boot application that uses a trained WEKA model to predict the species of an Iris flower based on user-provided measurements for sepal length, sepal width, petal length, and petal width.

## Project Overview

The project leverages:
- **Spring Boot** for creating a REST API.
- **WEKA** for machine learning model handling.
- An existing pre-trained model (`iris.model`) to make predictions on the well-known Iris dataset.

## Features

- REST endpoint to predict the Iris species based on input parameters.
- Uses WEKA's `MultiLayerPerceptron` model for predictions.

## Getting Started

### Prerequisites

Make sure you have the following installed:
- **Java 11** or higher
- **Gradle** (Recommended version 7.0+)
- **Git**

### Clone the Repository

To clone the project, use the following command:

```bash
git clone git@github.com:kaushald/java-weka-iris.git
cd java-weka-iris
```

### Build and Run the Project

1. **Build the project** using Gradle:

   ```bash
   ./gradlew build
   ```

2. **Run the application**:

   ```bash
   ./gradlew bootRun
   ```

The application will start on `http://localhost:8080`.

### How to Use

To predict the species of an Iris flower, make a `GET` request to the `/predict` endpoint with the following parameters:

- **sepalLength**: Length of the sepal in cm.
- **sepalWidth**: Width of the sepal in cm.
- **petalLength**: Length of the petal in cm.
- **petalWidth**: Width of the petal in cm.

#### Example Request

```bash
curl "http://localhost:8080/predict?sepalLength=5.1&sepalWidth=3.5&petalLength=1.4&petalWidth=0.2"
```

#### Example Response

```
Predicted Iris Species: Iris-setosa
```

## Project Structure

```
java-weka-iris
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   └── yourpackage
│   │   │   │       ├── controller
│   │   │   │       │   └── PredictionController.java
│   │   │   │       └── service
│   │   │   │           ├── PredictionService.java
│   │   │   │           └── WekaUtils.java
│   │   └── resources
│   │       └── iris.model
│   └── test
│
├── build.gradle
└── README.md
```

## Explanation

### How It Works

1. **Pre-trained Model**: The Iris prediction model (`iris.model`) was trained using WEKA's `MultiLayerPerceptron` algorithm and saved in WEKA. It is loaded into the application at startup.

2. **PredictionService**:
   - This service loads the pre-trained model from `src/main/resources/iris.model`.
   - When a prediction request is received, it creates a new data instance with the provided inputs.
   - The instance is classified using the loaded WEKA model, and the predicted species is returned.

3. **REST API**:
   - A simple REST endpoint (`/predict`) is exposed using Spring Boot's `@RestController`.
   - The user provides measurements via query parameters, which are then processed to make a prediction.

### Key Classes

- **PredictionService.java**: Core service that handles loading the model and making predictions.
- **WekaUtils.java**: Helper class to define the structure of the input dataset (matching the attributes used during training).
- **PredictionController.java**: REST controller to accept user inputs and return predictions.

## Contributing

Feel free to fork this repository and contribute by submitting a pull request. Improvements, suggestions, and bug fixes are welcome!

## License

This project is open source and available under the [MIT License](LICENSE).

## Contact

For any inquiries or issues, please contact **Kaushal Dalvi**.

