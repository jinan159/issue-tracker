import styled from 'styled-components';

import { ReactComponent as Alert } from '@/assets/icons/alert-circle.svg';
import { ReactComponent as Archive } from '@/assets/icons/archive.svg';
import { ReactComponent as Plus } from '@/assets/icons/plus.svg';
import { ReactComponent as Search } from '@/assets/icons/search.svg';

type IconObjType = typeof iconObj;

export type IconType = keyof IconObjType;

type IconsProps = {
  type: IconType;
  size?: string;
  color?: string;
  fill?: string;
};

const BASIC_SIZE = '16';
const BASIC_VIEWBOX = '0 0 16 16';

const iconObj = {
  search: Search,
  alert: Alert,
  plus: Plus,
  archive: Archive,
};

function Icons({ type, size = BASIC_SIZE, color, fill }: IconsProps) {
  const Icon = iconObj[type];
  const StyledIcon = styled(Icon)`
    path {
      stroke: ${color};
    }
    * {
      fill: ${fill};
    }
  `;
  return <StyledIcon width={size} height={size} viewBox={BASIC_VIEWBOX} />;
}

export default Icons;
