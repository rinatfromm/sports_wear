import { ReactComponent as MessageIcon } from '../../shared/icons/message.svg';
import { ReactComponent as DollarIcon } from '../../shared/icons/dollar.svg';
import { ReactComponent as AdvancedIcon } from '../../shared/icons/advanced.svg';


interface FeatureCard {
  icon: React.FunctionComponent<React.SVGProps<SVGSVGElement>>;
  title: string;
  description: string;
  link: string;
}


const featuresSectionCards: FeatureCard[] = [
  {
    icon: MessageIcon,
    title: "Unlimited cards",
    description: "Give your team the autonomy they need with access to as many cards as they need. Authorise purchases with a click. Simple.",
    link: "#massage",
  },
  {
    icon: DollarIcon,
    title: "Easy expense policies",
    description: "Every card comes with configurable spending limits, purchase restrictions, and cancellations for each employee and team.",
    link: "#yoga",
  },
  {
    icon: AdvancedIcon,
    title: "Advanced analytics",
    description: "An all-in-one platform that helps you balance everything your team need to be happy and your finances in order.",
    link: "#meditation",
  },
];

export default featuresSectionCards;


