import React from 'react';
import { Link } from 'react-router-dom';
import Button from '../../../shared/ui/button';
import styles from './LoginForm.module.css';
import google from '../../../shared/icons/google.svg';
import { useForm, SubmitHandler } from 'react-hook-form';
import { LoginFormData } from '../../../app/types/LoginFormData';
import { LoginFormProps } from '../../../app/types/LoginFormProps';
import { inputFields } from '../../../shared/utils/formConfig';
import InputField from '../../../shared/ui/inputField';



const LoginForm: React.FC<LoginFormProps> = ({ onClose }) => {

    const {
        register,
        handleSubmit,
        formState: { errors },
        reset,
    } = useForm<LoginFormData>({
        mode: "all",
    });


    const getDataFormInputs: SubmitHandler<LoginFormData> = (data) => {
        console.log(data);
        reset();
    };


    return (
        <form className={styles.form} onSubmit={handleSubmit(getDataFormInputs)}>
            <Button className='formBtn' title='X' onClick={onClose} />
            <div className={styles.formContentContainer}>
                <h3 className={styles.formTitle}>Welcome back</h3>
                <p className={styles.formText}>
                    We are pleased to know that you have decided to continue your sports adventure with us.
                </p>
                <div className={styles.inputContainer}>
                    {inputFields.map((field) => {
                        return (
                            <InputField
                                key={field.name}
                                name={field.name}
                                validation={field.validation}
                                placeholder={field.placeholder}
                                register={register}
                                errors={errors}
                                className={"inputWrapper"}
                            />
                        );
                    })}
                </div>
                <div className={styles.formBtnsContainer}>
                    <Button className='formBtnContinue' title='Continue' />
                    <Button className='formBtnGoogle' title='Log In with Google' />
                    <img src={google} alt='Google' className={styles.google} />
                </div>
                <span className={styles.toLink}>
                    Don’t have an account? <Link to="/" className={styles.linkSignUp}> Sign Up</Link>
                </span>
            </div>
            <div className={styles.formAddress}>
                <p className={styles.addressLinks}>© 2077 UI. All rights reserved.</p>
                <Link to={'/'} className={styles.addressRight}>mainoffice@sportego.com</Link>
            </div>
        </form>
    );
};

export default LoginForm;

