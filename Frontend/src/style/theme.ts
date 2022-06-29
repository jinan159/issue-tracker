import { DefaultTheme } from 'styled-components';

const colors = {
  greyScale: {
    titleActive: '#14142B',
    body: '#4E4B66',
    label: '#6E7191',
    placeholder: '#A0A3BD',
    border: '#D7D9E7',
    line: '#D9DBE9',
    inputBackground: '#EFF0F6',
    background: '#F7F7FC',
    offWhite: '#FEFEFE',
  },
  blueScale: {
    blue: '#007AFF',
    lightBlue: '#C7EBFF',
    darkBlue: '#004DE3',
  },
  purpleScale: {
    purple: '#0025E7',
    lightPurple: '#CCD4FF',
    darkPurple: '#020070',
  },
  redScale: {
    red: '#FF3B30',
    lightRed: '#FFD1CF',
    darkRed: '#C60B00',
  },
  greenScale: {
    green: '#34C759',
    lightGreen: '#DDFFE6',
    darkGreen: '#00A028',
  },
};

const mixins = {
  flexBox: (direction = 'row', align = 'center', justify = 'center') => `
    display: flex;
    flex-direction: ${direction};
    align-items: ${align};
    justify-content: ${justify};
  `,
};

const width = {
  base: {
    'min-width': '1280px',
  },
};

const theme: DefaultTheme = {
  colors,
  mixins,
  width,
};

type ColorType = typeof colors;
type MixinsType = typeof mixins;
type WidthType = typeof width;
type ThemeType = typeof theme;

export type { ColorType, MixinsType, ThemeType, WidthType };

export default theme;
