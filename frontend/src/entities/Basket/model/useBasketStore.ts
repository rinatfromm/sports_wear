import { create } from 'zustand';
import { BasketItem } from './basketTypes'



interface BasketState {
    items: BasketItem[];
    addItem: (item: BasketItem) => void;
    removeItem: (id: number) => void;
    clearBasket: () => void;
}

const useBasketStore = create<BasketState>((set) => ({
    items: [],
    addItem: (item) =>
        set((state) => ({
            items: [...state.items, { ...item, quantity: 1 }]
        })),
    removeItem: (id) =>
        set((state) => ({
            items: state.items.filter((item) => item.id !== id),
        })),
    clearBasket: () => set({ items: [] }),
}));

export default useBasketStore;