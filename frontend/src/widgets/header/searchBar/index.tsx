import styles from './SearchBar.module.css';
import search from '../../../shared/icons/search.svg';

const SearchBar: React.FC = () => {
    return (
        <div className={styles.inputWrapper}>
            <input type="text" className={styles.search} placeholder="Search" />
            <img src={search} alt="Search Icon" className={styles.icon} />
        </div>
    );
};

export default SearchBar;