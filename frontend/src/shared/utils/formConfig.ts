import { LoginFormData } from "../../app/types/LoginFormData";
import { Validation } from "../../app/types/Validation";
import {
    passwordInputValidation,
    emailInputValidation,
} from "./validation";



interface InputFieldConfig {
    name: keyof LoginFormData;
    validation: Validation;
    placeholder: string;
}

export const inputFields: InputFieldConfig[] = [
    {
        name: "email",
        validation: emailInputValidation,
        placeholder: "Enter your email",
    },
    {
        name: "password",
        validation: passwordInputValidation,
        placeholder: "Enter your password",
    },
];