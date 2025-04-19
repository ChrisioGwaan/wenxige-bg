import uuid
from datetime import datetime
from app.extensions import db
from app.enums import Role


class SysUser(db.Model):
    __tablename__ = "sys_user"

    id = db.Column(db.String(36), primary_key=True, default=lambda: str(uuid.uuid4()))
    username = db.Column(db.String(50), nullable=False, unique=True)
    firstname = db.Column(db.String(50))
    lastname = db.Column(db.String(50))
    password = db.Column(db.String(128), nullable=False)
    email = db.Column(db.String(120), nullable=False, unique=True)
    role = db.Column(db.Enum(Role), nullable=False, default=Role.USER)
    token = db.Column(db.String(255))
    create_user = db.Column(db.String(50))
    modified_user = db.Column(db.String(50))
    create_time = db.Column(db.DateTime, default=datetime.utcnow, nullable=False)
    modified_time = db.Column(
        db.DateTime, default=datetime.utcnow, onupdate=datetime.utcnow, nullable=False
    )
    is_del = db.Column(db.Boolean, default=False, nullable=False)

    def __repr__(self):
        return f"<SysUser {self.username}>"
