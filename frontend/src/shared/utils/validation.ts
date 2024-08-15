import { Validation } from "../../app/types/Validation";

export const emailInputValidation: Validation = {
    required: "Email is required",
    pattern: {
        value: /[^@ \t\r\n]+@[^@ \t\r\n]+\.[^@ \t\r\n]+/,
        message: "Invalid email",
    },
};


export const passwordInputValidation: Validation = {
    required: "Password is required",
    pattern: {
        value: /^(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{8,}$/,
        message: "Password must be at least 8 characters long, contain at least one capital letter, and at least one digit.",
    },
};

