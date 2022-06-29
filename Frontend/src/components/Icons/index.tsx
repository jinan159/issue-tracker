import { ReactComponent as Alert } from '@/assets/icons/alert-circle.svg';
import { ReactComponent as Archive } from '@/assets/icons/archive.svg';
import { ReactComponent as Plus } from '@/assets/icons/plus.svg';
import { ReactComponent as Search } from '@/assets/icons/search.svg';

type iconComponentMapType = typeof iconComponentMap;

export type IconType = keyof iconComponentMapType;

type IconsProps = {
  type: IconType;
  size?: string;
};

const BASIC_SIZE = '16';
const BASIC_VIEWBOX = '0 0 16 16';

const iconComponentMap = {
  search: Search,
  alert: Alert,
  plus: Plus,
  archive: Archive,
};

export default function Icons({ type, size = BASIC_SIZE }: IconsProps) {
  const Icon = iconComponentMap[type];
  return <Icon width={size} height={size} viewBox={BASIC_VIEWBOX} />;
}
