"""
Author: chrisiogwaan
Description: Main Flask application file that initializes the app, registers blueprints, and sets up error handling.
"""

from flask import Flask, jsonify
from api.routes import api_blueprint
from response_utils import error_response
from flask import Flask, jsonify
from flask_cors import CORS

app = Flask(__name__)
app.config.from_object("config.Config")

app.register_blueprint(api_blueprint, url_prefix="/api/v1")

CORS(
    app,
    resources={r"/api/*": {"origins": "*"}},
    supports_credentials=True,
    expose_headers=["Content-Disposition"],
)


# Welcome route
@app.route("/")
def index():
    return jsonify({"message": "Welcome to the Flask API!"})


# Route to demonstrate CORS
@app.route("/api/data", methods=["GET"])
def get_data():
    data = {"info": "This is accessible to any origin"}
    return jsonify(data)


# Global error handler for 400 Bad Request
@app.errorhandler(400)
def handle_bad_request(error):
    return jsonify(error_response(msg=f"Bad Request: {error.description}")), 400


@app.errorhandler(401)
def handle_unauthorized(error):
    return (
        jsonify(
            error_response(
                msg="Unauthorized: You need to log in to access this resource"
            )
        ),
        401,
    )


# Global error handler for 403 Forbidden
@app.errorhandler(403)
def handle_forbidden(error):
    return (
        jsonify(
            error_response(
                msg="Forbidden: You don't have permission to access this resource"
            )
        ),
        403,
    )


# Global error handler for 404 Not Found
@app.errorhandler(404)
def handle_not_found(error):
    return jsonify(error_response(msg="Resource not found")), 404


# Global error handler for 500 Internal Server Error
@app.errorhandler(500)
def handle_server_error(error):
    return jsonify(error_response(msg="Internal Server Error")), 500


# Global error handler for 501 Not Implemented
@app.errorhandler(501)
def handle_not_implemented(error):
    return (
        jsonify(error_response(msg="Not Implemented: This feature is not available")),
        501,
    )


# Global error handler for 502 Bad Gateway
@app.errorhandler(502)
def handle_bad_gateway(error):
    return (
        jsonify(
            error_response(msg="Bad Gateway: The server received an invalid response")
        ),
        502,
    )


# Global error handler for 503 Service Unavailable
@app.errorhandler(503)
def handle_service_unavailable(error):
    return (
        jsonify(
            error_response(
                msg="Service Unavailable: The server is currently unable to handle the request"
            )
        ),
        503,
    )


# Global error handler for 504 Gateway Timeout
@app.errorhandler(504)
def handle_gateway_timeout(error):
    return (
        jsonify(
            error_response(
                msg="Gateway Timeout: The server did not receive a timely response"
            )
        ),
        504,
    )


if __name__ == "__main__":
    app.run(debug=True)
