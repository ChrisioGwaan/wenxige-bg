import uuid
from datetime import datetime
from app.extensions import db
from app.enums import Role


class SysUser(db.Model):
    __tablename__ = "sys_user"

    # UUID primary key
    id = db.Column(db.String(36), primary_key=True, default=lambda: str(uuid.uuid4()))

    # Username
    username = db.Column(db.String(50), nullable=False, unique=True)

    # User's first name
    firstname = db.Column(db.String(50))

    # User's last name
    lastname = db.Column(db.String(50))

    # User's password
    password = db.Column(db.String(128), nullable=False)

    # User's email
    email = db.Column(db.String(120), nullable=False, unique=True)

    # User's role
    role = db.Column(db.Enum(Role), nullable=False, default=Role.USER)

    # User's token
    token = db.Column(db.String(255))

    # Created by and modified by
    create_user = db.Column(db.String(50))
    modified_user = db.Column(db.String(50))

    # Timestamps
    # Created time and modified time
    create_time = db.Column(db.DateTime, default=datetime.now, nullable=False)
    modified_time = db.Column(
        db.DateTime, default=datetime.now, onupdate=datetime.now, nullable=False
    )

    # User deletion status
    is_del = db.Column(db.Boolean, default=False, nullable=False)

    def __repr__(self):
        return f"<SysUser {self.username}>"
