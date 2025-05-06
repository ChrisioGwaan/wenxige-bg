import uuid
from datetime import datetime
from app.extensions import db
from app.enums import Role


class SysUser(db.Model):
    __tablename__ = "sys_user"

    # UUID primary key
    id = db.Column(db.String(256), primary_key=True, default=lambda: str(uuid.uuid4()))
    
    # User's avatar file ID
    avatar_file_id = db.Column(db.BigInteger, nullable=True)

    # Username
    username = db.Column(db.String(64), nullable=False, unique=True)

    # User's first name
    firstname = db.Column(db.String(64), nullable=True)

    # User's last name
    lastname = db.Column(db.String(64), nullable=True)

    # User's password
    password = db.Column(db.String(64), nullable=False)

    # User's email
    email = db.Column(db.String(120), nullable=True, unique=True)

    # User's role Big Id
    sys_role_id = db.Column(db.Integer, nullable=False)

    # Created by and modified by
    create_user = db.Column(db.String(50), nullable=False)
    modified_user = db.Column(db.String(50), nullable=True)

    # Timestamps
    # Created time and modified time
    create_time = db.Column(db.DateTime, default=datetime.now, nullable=False)
    modified_time = db.Column(
        db.DateTime, default=datetime.now, onupdate=datetime.now, nullable=True
    )
    
    # User status
    is_locked = db.Column(db.Integer, default=1, nullable=False)

    # User deletion status
    is_del = db.Column(db.Boolean, default='0', nullable=False)

    def __repr__(self):
        return f"<SysUser {self.username}>"
