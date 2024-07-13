import { create } from 'zustand';
import axiosInstance from '../../../shared/api/axiosInstance';
import { Product } from './productTypes';

interface ProductState {
    productsAll: Product[];
    loading: boolean;
    error: string | null;
    fetchProducts: () => Promise<void>;
}

const useProductStore = create<ProductState>((set) => ({
    productsAll: [],
    loading: false,
    error: null,

    fetchProducts: async () => {
        set({ loading: true, error: null });
        try {
            const response = await axiosInstance.get<Product[]>('/get/all');
            set({ productsAll: response.data, loading: false });
        } catch (error) {
            set({ error: (error as Error).message, loading: false });
        }
    }
}));

export default useProductStore;