import 'styled-components';

import { ColorType, MixinsType, WidthType } from '@/style/theme';

declare module 'styled-components' {
  export interface DefaultTheme {
    colors: ColorType;
    mixins: MixinsType;
    width: WidthType;
  }
}
