from marshmallow import Schema, fields
from app.enums import Role


class UserSchema(Schema):
    id = fields.String(dump_only=True)
    username = fields.String(required=True)
    firstname = fields.String()
    lastname = fields.String()
    email = fields.Email(required=True)
    role = fields.String(validate=lambda r: r in Role._member_names_)
