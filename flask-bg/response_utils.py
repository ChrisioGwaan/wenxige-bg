"""
Author: chrisiogwaan
Description: Utility functions for generating standardized JSON responses in a Flask application.
"""


def success_response(data=None, msg="Operation successful"):
    """
    Returns a standardized successful JSON response.
    :param data: The data to include (default: None)
    :param msg: Success message (default: "Operation successful")
    :return: A dict with code 0, data, and msg
    """
    return {"code": 0, "data": data, "msg": msg}


def error_response(msg="Operation failed", data=None):
    """
    Returns a standardized error JSON response.
    :param msg: Error message (default: "Operation failed")
    :param data: Optional extra data (default: None)
    :return: A dict with code 1, data, and msg
    """
    return {"code": 1, "data": data, "msg": msg}
