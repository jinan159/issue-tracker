const colors = {
  greyScale: {
    titleActive: '#14142B',
    body: '#4E4B66',
    label: '#6E7191',
    placeholder: '#A0A3BD',
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

const theme = {
  colors,
  mixins,
  width,
};

type ThemeType = typeof theme;

export type { ThemeType };

export default theme;
