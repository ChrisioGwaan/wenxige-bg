from flask import Flask, jsonify

from .config import Config
from .extensions import db, migrate, cors
from .http_status import http_status

from .controllers.sys_user_controller import user_bp
from .controllers.main_controller import main_bp


def create_app():
    app = Flask(__name__)
    app.config.from_object(Config)

    db.init_app(app)
    migrate.init_app(app, db)
    cors.init_app(
        app,
        resources={r"/api/*": {"origins": "*"}},
        supports_credentials=True,
        expose_headers=["Content-Disposition"],
    )

    app.register_blueprint(main_bp)
    app.register_blueprint(user_bp, url_prefix="/api/v1/users")

    http_status(app)

    @app.route("/")
    def index():
        return jsonify({"message": "Welcome to the Flask API!"})

    # Route to demonstrate CORS
    @app.route("/api/data", methods=["GET"])
    def get_data():
        data = {"info": "This is accessible to any origin"}
        return jsonify(data)

    return app
