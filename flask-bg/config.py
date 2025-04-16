"""
Author: chrisiogwaan
Description: Configuration file for the Flask application.
"""

import os
from dotenv import load_dotenv

load_dotenv()


class Config:
    DEBUG = True
    SECRET_KEY = os.environ.get("SECRET_KEY", "default_secret_key")
    SQLALCHEMY_DATABASE_URI = os.environ.get("DATABASE_URL")
    SQLALCHEMY_TRACK_MODIFICATIONS = False
