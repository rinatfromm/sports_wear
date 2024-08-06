import { ReactComponent as Biosynthesis } from '../../shared/ assets/  images/Biosynthesis.svg';
import { ReactComponent as Nietzche } from '../../shared/ assets/  images/Nietzche.svg';
import { ReactComponent as Sisyphus } from '../../shared/ assets/  images/Sisyphus.svg';
import { ReactComponent as CloudWatch } from '../../shared/ assets/  images/CloudWatch.svg';




interface PartnersLogo {
    logo: React.FunctionComponent<React.SVGProps<SVGSVGElement>>;

}


const partnersLogo: PartnersLogo[] = [
    {
        logo: Biosynthesis
    },
    {
        logo: Nietzche
    },
    {
        logo: Sisyphus
    },
    {
        logo: CloudWatch
    },
]

export default partnersLogo;