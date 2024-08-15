import { useState } from 'react';

export function useAuth() {
    const [isModalOpen, setIsModalOpen] = useState<boolean>(false);

    const handleLoginClick = () => {
        setIsModalOpen(true);
    };

    const handleCloseModal = () => {
        setIsModalOpen(false);
    };

    return {
        isModalOpen,
        handleLoginClick,
        handleCloseModal
    };
}