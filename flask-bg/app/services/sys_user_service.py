from app.extensions import db
from app.models.sys_user import SysUser
from datetime import datetime


class UserService:
    @staticmethod
    def get_all_users():
        return SysUser.query.filter_by(is_del=False).all()

    @staticmethod
    def create_user(data):
        user = SysUser(**data)
        user.create_time = datetime.now()
        user.modified_time = datetime.now()
        db.session.add(user)
        db.session.commit()
        return user
