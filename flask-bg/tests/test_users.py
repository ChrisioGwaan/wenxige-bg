"""
Author: chrisiogwaan
Description: Unit tests for the Flask API application.
"""

import unittest
from app import app


class APITestCase(unittest.TestCase):
    def setUp(self):
        self.client = app.test_client()

    def test_get_users_response_format(self):
        response = self.client.get("/api/users")
        json_data = response.get_json()
        self.assertEqual(json_data.get("code"), 0)
        self.assertIn("name", json_data.get("data")[0])
        self.assertIsInstance(json_data.get("msg"), str)
        self.assertIsInstance(json_data.get("data"), list)


if __name__ == "__main__":
    unittest.main()
