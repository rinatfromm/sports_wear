import { FC, Fragment } from "react";
import styles from './Layout.module.css';
import Footer from "../../widgets/footer";
import Header from "../../widgets/header";
import { Outlet, useLocation } from "react-router-dom";
import HeaderOther from "../../widgets/headerOther";

const Layout: FC = () => {
    const location = useLocation();

    const renderHeader = () => {
        if (location.pathname === '/') {
            return <Header />;
        } else {
            return <HeaderOther />;
        }
    };

    return (
        <Fragment>
            <div className="App">
                {renderHeader()}
                <main className={styles.mainContainer}>
                    <Outlet />
                </main>
                <Footer />
            </div>
        </Fragment>
    );
};

export default Layout;
