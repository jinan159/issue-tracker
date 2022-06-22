import user from '../../../public/image/user1.jpeg';
import UserImg from '../UserImg';
import * as S from './style';

function Header() {
  return (
    <S.Container>
      <S.LogoLink to="/">
        <S.Title>Issue Tracker</S.Title>
      </S.LogoLink>
      <UserImg img={user} size="medium" alt="user logo" />
    </S.Container>
  );
}

export default Header;
