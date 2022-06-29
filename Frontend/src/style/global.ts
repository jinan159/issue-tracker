import { createGlobalStyle } from 'styled-components';
import reset from 'styled-reset';

import { ThemeType } from './theme';

const GlobalStyle = createGlobalStyle<{ theme: ThemeType }>`
  ${reset}
  
  body {
  }
  
  input {
    border: none;
    outline: none;
    background-color: transparent;
  }

  button {
    border: none;
    cursor: pointer;
  }
  
  .app {
    width: 100vw;
    height: 100vh;
    ${({ theme: { width } }) => width.base};
  }
`;

export default GlobalStyle;
