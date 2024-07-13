export interface Product {
    id: string;
    personalInfo: {
        id: string;
        name: string;
        lastName: string;
        middleName: string;
        phone: string;
        email: string;
        birthDate: string;
        created: string;
        updated: string;
    };
    basket: {
        id: string;
        itemId: {
            id: string;
            name: string;
            category: string;
            size: string;
            price: number; 
            weight: number;
            color: string;
            inStock: number;
            created: string;
            updated: string;
        };
        quantity: number;
    };
    active: boolean;
    created: string;
    updated: string;
}
