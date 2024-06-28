import React from 'react';
import styles from '../../../app/styles/NavBar.module.css';
import { NavLink } from 'react-router-dom';
import { navigationItems} from '../configHeader';
import { NavItem } from '../../../app/types/NavItem';

const NavBar: React.FC = () => {
  return (
    <ul className={styles.navBar}>
      {navigationItems.map((item: NavItem, index: number) => (
        <li key={index} className={styles.navItem}>
          <NavLink
            to={item.to}
            className={({ isActive }) => isActive ? styles.activeLink : styles.link}
          >
            {item.text}
          </NavLink>
        </li>
      ))}
    </ul>
  );
};

export default NavBar;
