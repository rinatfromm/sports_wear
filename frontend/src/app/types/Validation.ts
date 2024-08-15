export interface Validation {
    required?: string | boolean;
    minLength?: {
        value: number;
        message: string;
    };
    maxLength?: {
        value: number;
        message: string;
    };
    pattern?: {
        value: RegExp;
        message: string;
    };
}