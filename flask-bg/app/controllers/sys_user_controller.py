from flask import Blueprint, request, jsonify
from app.services.sys_user_service import UserService
from app.utils import response_utils
from app.vo.sys_user_vo import UserVO

user_bp = Blueprint("users", __name__)
user_schema = UserVO()
users_schema = UserVO(many=True)


@user_bp.route("/", methods=["GET"])
def list_users():
    users = UserService.get_all_users()
    result = users_schema.dump(users)
    return jsonify(response_utils.success_response(data=result))


@user_bp.route("/", methods=["POST"])
def add_user():
    json_data = request.get_json()
    # validate
    errors = user_schema.validate(json_data)
    if errors:
        return jsonify(response_utils.error_response(msg=errors)), 400

    user = UserService.create_user(json_data)
    return (
        jsonify(
            response_utils.success_response(
                data=user_schema.dump(user), msg="User created"
            )
        ),
        201,
    )
