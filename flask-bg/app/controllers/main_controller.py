from flask import Blueprint, jsonify

main_bp = Blueprint("main", __name__)


@main_bp.route("/")
def index():
    return jsonify({"message": "Welcome to the Flask API!"})


@main_bp.route("/api/data", methods=["GET"])
def get_data():
    data = {"info": "This is accessible to any origin"}
    return jsonify(data)
