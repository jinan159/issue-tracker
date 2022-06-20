const color = {
  black: '#14142B',
  white: '#FEFEFE',
  grey1: '#6E7191',
  grey2: '#D9DBE9',
  grey3: '#EFF0F6',
  grey4: '#F7F7FC',
  blue1: '#007AFF',
  blue2: '#C7EBFF',
  red: '#FF3B30',
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
  color,
  mixins,
  width,
};

type ThemeType = typeof theme;

export type { ThemeType };

export default theme;
