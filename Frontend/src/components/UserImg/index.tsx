import * as S from './style';

type TUserImgProps = {
  img: string;
  size: 'small' | 'medium';
  alt?: string;
};

function UserImg({ img, size, alt }: TUserImgProps) {
  return (
    <S.Container size={size}>
      <S.Img src={img} size={size} alt={alt} />
    </S.Container>
  );
}

export default UserImg;
