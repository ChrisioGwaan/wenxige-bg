# Security Policy

## 🚨 Security Alert

**WARNING: Recent phishing attempt detected in this repository.**

Do NOT click on suspicious links in issues, especially those requesting GitHub token verification or OAuth permissions. Issue #18 contains a malicious link - DO NOT click it or authorize any permissions.

## Reporting Security Vulnerabilities

If you discover a security vulnerability in this project, please report it responsibly:

### 📧 Contact Information

- **Email**: chris322322@gmail.com
- **Subject Line**: `[SECURITY] Vulnerability Report - wenxige-bg`

### 📝 What to Include

Please include the following information in your security report:

1. **Description** of the vulnerability
2. **Steps to reproduce** the issue
3. **Potential impact** assessment
4. **Suggested fix** (if you have one)
5. **Your contact information** for follow-up

### ⚡ Response Timeline

- **Initial Response**: Within 48 hours
- **Status Update**: Within 1 week
- **Resolution Target**: Within 30 days (depending on severity)

## 🔒 Security Best Practices for Contributors

### Authentication & Tokens

- **Never** commit secrets, tokens, passwords, or API keys to the repository
- Use environment variables for sensitive configuration
- Regularly audit and rotate your GitHub personal access tokens
- Enable two-factor authentication (2FA) on your GitHub account

### Suspicious Activity

- **Be vigilant** about unusual issues or pull requests
- **Verify identity** of unknown contributors before engaging
- **Report suspicious links** immediately to maintainers
- **Do not click** on unverified external links in issues/PRs

### Code Security

- Review dependencies regularly for known vulnerabilities
- Follow secure coding practices
- Test security-related changes thoroughly
- Keep sensitive operations in secure, authenticated endpoints

## 🚨 Current Security Alerts

### Phishing Attempt - August 2025

**Issue**: Malicious user created issue #18 with phishing link targeting GitHub tokens
**Status**: Active threat - DO NOT INTERACT
**Action Required**: Report similar incidents immediately

## 📋 Supported Versions

| Version | Supported          |
| ------- | ------------------ |
| Latest  | :white_check_mark: |
| Older   | :x:                |

## 🛡️ Security Features

This project implements:

- JWT-based authentication
- Password encryption
- Role-based access control (RBAC)
- Secure file upload/download
- SQL injection protection via MyBatis Plus

## 📚 Additional Resources

- [GitHub Security Best Practices](https://docs.github.com/en/code-security)
- [OWASP Top 10](https://owasp.org/www-project-top-ten/)
- [Spring Security Documentation](https://spring.io/projects/spring-security)

---

**Remember**: When in doubt about security issues, always err on the side of caution and report suspicious activity immediately.