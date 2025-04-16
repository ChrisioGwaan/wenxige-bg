"""
Author: chrisiogwaan
Description: Routes for the Flask API application.
"""

from flask import Blueprint, request, abort, jsonify
from response_utils import success_response, error_response

api_blueprint = Blueprint("api", __name__)


@api_blueprint.route("/users", methods=["GET"])
def get_users():
    try:
        users = [{"id": 1, "name": "Alice"}, {"id": 2, "name": "Bob"}]
        return jsonify(success_response(data=users, msg="Users retrieved successfully"))
    except Exception as e:
        return jsonify(error_response(msg=str(e))), 500


@api_blueprint.route("/users", methods=["POST"])
def create_user():
    data = request.get_json()
    if not data or "name" not in data:
        return jsonify(error_response(msg="Name is required")), 400

    try:
        new_user = {"id": 3, "name": data["name"]}
        return (
            jsonify(success_response(data=new_user, msg="User created successfully")),
            201,
        )
    except Exception as e:
        return jsonify(error_response(msg=str(e))), 500
