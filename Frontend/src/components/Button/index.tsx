/* eslint-disable react/require-default-props */
import StyledButton from './style';

interface ButtonProps {
  className?: string;
  icon: string;
  disabled?: boolean;
  onClick?: () => void;
}
export default function Button({
  className,
  icon,
  disabled,
  onClick,
}: ButtonProps) {
  return (
    <StyledButton disabled={disabled} className={className} onClick={onClick}>
      {icon}
    </StyledButton>
  );
}
