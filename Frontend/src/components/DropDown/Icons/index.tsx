import styled, { useTheme } from 'styled-components';

import { ReactComponent as Alert } from '@/assets/icons/alert-circle.svg';
import { ReactComponent as BottomArrow } from '@/assets/icons/bottom-arrow.svg';
import { ReactComponent as Label } from '@/assets/icons/label.svg';
import { ReactComponent as MileStone } from '@/assets/icons/mileStone.svg';
import { ReactComponent as Search } from '@/assets/icons/search.svg';

type IconObjType = typeof iconObj;

type IconsProps = {
  type: keyof IconObjType;
  size?: string;
  fill?: string;
  version?: string;
  mode?: string;
};

const BASIC_SIZE = '16';
const BASIC_VIEWBOX = '0 0 16 16';

const iconObj = {
  search: Search,
  alert: Alert,
  bottomArrow: BottomArrow,
  label: Label,
  mileStone: MileStone,
};

function Icons({
  type,
  size = BASIC_SIZE,
  fill,
  version = 'black',
  mode = 'initial',
}: IconsProps) {
  const theme = useTheme();

  const iconStyle = [
    {
      iconType: 'bottomArrow',
      iconVersion: 'black',
      modes: [
        {
          iconMode: 'initial',
          color: theme.colors.greyScale.label,
        },
        {
          iconMode: 'hover',
          color: theme.colors.greyScale.body,
        },
      ],
    },
    {
      iconType: 'label',
      iconVersion: 'black',
      modes: [
        {
          iconMode: 'initial',
          color: theme.colors.greyScale.label,
        },
        {
          iconMode: 'hover',
          color: theme.colors.greyScale.body,
        },
        {
          iconMode: 'active',
          color: theme.colors.greyScale.titleActive,
        },
      ],
    },
    {
      iconType: 'mileStone',
      iconVersion: 'black',
      modes: [
        {
          iconMode: 'initial',
          color: theme.colors.greyScale.label,
        },
        {
          iconMode: 'hover',
          color: theme.colors.greyScale.body,
        },
        {
          iconMode: 'active',
          color: theme.colors.greyScale.titleActive,
        },
      ],
    },
  ];

  const Icon = iconObj[type];
  const index = iconStyle.findIndex(
    ({ iconType, iconVersion }) => iconType === type && iconVersion === version
  );
  const targetIconModes = iconStyle[index].modes;
  const targetColorIndex = targetIconModes.findIndex(
    ({ iconMode }) => iconMode === mode
  );
  const targetColor = targetIconModes[targetColorIndex]?.color;

  const StyledIcon = styled(Icon)`
    path {
      stroke: ${targetColor};
    }
    * {
      fill: ${fill};
    }
  `;

  return <StyledIcon width={size} height={size} viewBox={BASIC_VIEWBOX} />;
}

export default Icons;
