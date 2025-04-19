from app.extensions import db
from app.models.sys_user import SysUser


class UserService:
    @staticmethod
    def get_all_users():
        return SysUser.query.filter_by(is_del=False).all()

    @staticmethod
    def create_user(data):
        user = SysUser(**data)
        db.session.add(user)
        db.session.commit()
        return user
