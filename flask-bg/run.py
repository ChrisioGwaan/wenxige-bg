"""
Author: chrisiogwaan
Description: Main Flask application file that initializes the app, registers blueprints, and sets up error handling.
"""

from app import create_app

app = create_app()


if __name__ == "__main__":
    app.run(debug=True)
