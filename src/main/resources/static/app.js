// Global configuration
const API_BASE_URL = 'http://localhost:8080';

// Utility function to make API calls
async function apiCall(endpoint, method = 'GET', data = null) {
    const options = {
        method: method,
        headers: {
            'Content-Type': 'application/json',
        }
    };
    
    if (data) {
        options.body = JSON.stringify(data);
    }
    
    try {
        const response = await fetch(`${API_BASE_URL}${endpoint}`, options);
        return response;
    } catch (error) {
        console.error('API call error:', error);
        throw error;
    }
}

// Check authentication
function checkAuth(requiredRole = null) {
    const currentUser = JSON.parse(localStorage.getItem('currentUser'));
    
    if (!currentUser) {
        return false;
    }
    
    if (requiredRole && currentUser.role !== requiredRole) {
        return false;
    }
    
    return currentUser;
}

// Format currency
function formatCurrency(amount) {
    return `₹${parseFloat(amount).toFixed(2)}`;
}

// Show notification
function showNotification(message, type = 'info') {
    // Simple alert for now - can be enhanced with custom notification UI
    alert(message);
}

// Validate email
function isValidEmail(email) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

// Validate form
function validateForm(formData) {
    for (let key in formData) {
        if (!formData[key] || formData[key].toString().trim() === '') {
            return { valid: false, message: `${key} is required` };
        }
    }
    return { valid: true };
}

// Export functions for use in HTML files
window.apiCall = apiCall;
window.checkAuth = checkAuth;
window.formatCurrency = formatCurrency;
window.showNotification = showNotification;
window.isValidEmail = isValidEmail;
window.validateForm = validateForm;

