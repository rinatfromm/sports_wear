import { FieldErrors, UseFormRegister } from 'react-hook-form';
import { Validation } from '../../../app/types/Validation';
import ErrorMessage from '../errorMessage';
import styles from './InputField.module.css'
import { FormInputs } from '../../../app/types/FormInputs';
import { LoginFormData } from '../../../app/types/LoginFormData';




interface InputFieldProps {
    name: keyof LoginFormData,
    validation: Validation,
    placeholder?: string,
    register: UseFormRegister<FormInputs>,
    errors: FieldErrors<FormInputs>,
    className?: string,
}


const InputField: React.FC<InputFieldProps> = ({
    name,
    validation,
    placeholder,
    register,
    errors,
    className
}) => {
    const error = errors[name];

    return (
        <div className={className}>
            <input
                {...register(name, validation)}
                type="text"
                placeholder={placeholder}
                className={styles.input}
            />
            {error?.message && (
                <ErrorMessage
                    message={error.message}
                    className="errorMessage"
                />
            )}
        </div>
    );
};

export default InputField;